package jpuppeteer.chrome;

import jpuppeteer.api.browser.BoxModel;
import jpuppeteer.api.browser.Coordinate;
import jpuppeteer.api.browser.Element;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.USKeyboardDefinition;
import jpuppeteer.cdp.cdp.entity.dom.FocusRequest;
import jpuppeteer.cdp.cdp.entity.dom.GetBoxModelRequest;
import jpuppeteer.cdp.cdp.entity.dom.GetBoxModelResponse;
import jpuppeteer.cdp.cdp.entity.dom.SetFileInputFilesRequest;
import jpuppeteer.cdp.cdp.entity.input.InsertTextRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.RemoteObject;
import jpuppeteer.chrome.util.ScriptUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeElement extends ChromeBrowserObject implements Element {

    private static final String SCRIPT_SELECT = ScriptUtils.load("select.js");

    protected ChromePage page;

    protected ChromeElement(ChromeFrame frame, RemoteObject object) {
        super(frame, object);
        if (frame instanceof ChromePage) {
            this.page = (ChromePage) frame;
        } else {
            ChromeFrame up = null;
            while (up.parent != null) {
                up = up.parent;
            }
            this.page = (ChromePage) up;
        }
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        CallArgument parent = new CallArgument();
        parent.setObjectId(objectId);
        CallArgument argSelector = new CallArgument();
        argSelector.setValue(selector);
        ChromeBrowserObject object = frame.evaluate("function(parent, selector){return parent.querySelector(selector);}", false, parent, argSelector);
        return new ChromeElement(frame, object.object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        CallArgument parent = new CallArgument();
        parent.setObjectId(objectId);
        CallArgument argSelector = new CallArgument();
        argSelector.setValue(selector);
        ChromeBrowserObject object = frame.evaluate("function(parent, selector){return parent.querySelectorAll(selector);}", false, parent, argSelector);
        List<ChromeBrowserObject> properties = object.getProperties();
        return properties.stream().map(obj -> new ChromeElement(frame, obj.object)).collect(Collectors.toList());
    }

    @Override
    public ChromeFrame frame() {
        return frame;
    }

    @Override
    public BoxModel boxModel() throws Exception {
        GetBoxModelRequest request = new GetBoxModelRequest();
        request.setObjectId(objectId);
        GetBoxModelResponse resp = frame.dom.getBoxModel(request, DEFAULT_TIMEOUT);
        return new BoxModel(
                resp.getModel().getWidth(),
                resp.getModel().getHeight(),
                toCoordinates(resp.getModel().getContent()),
                toCoordinates(resp.getModel().getPadding()),
                toCoordinates(resp.getModel().getBorder()),
                toCoordinates(resp.getModel().getMargin())
        );
    }

    private List<Coordinate> toCoordinates(List<Double> items) {
        List<Coordinate> coordinates = new ArrayList<>(items.size() / 2);
        for(int i=0; i<items.size();) {
            coordinates.add(new Coordinate(items.get(i++), items.get(i++)));
        }
        return coordinates;
    }

    private Coordinate getCenter() throws Exception {
        BoxModel boxModel = boxModel();
        return new Coordinate(
                boxModel.getContent()[0].getX() + boxModel.getWidth() / 2,
                boxModel.getContent()[0].getY() + boxModel.getHeight() / 2
        );
    }

    @Override
    public void uploadFile(File... files) throws Exception {
        List<String> names = Arrays.stream(files).map(file -> file.getAbsolutePath()).collect(Collectors.toList());
        SetFileInputFilesRequest request = new SetFileInputFilesRequest();
        request.setFiles(names);
        request.setObjectId(objectId);
        frame.dom.setFileInputFiles(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void focus() throws Exception {
        FocusRequest request = new FocusRequest();
        request.setObjectId(objectId);
        frame.dom.focus(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void hover() throws Exception {
        Coordinate center = getCenter();
        page.mouseMove(center.getX(), center.getY(), 1);
    }

    private void insertText(String text) throws Exception {
        InsertTextRequest request = new InsertTextRequest();
        request.setText(text);
        frame.input.insertText(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void click(MouseDefinition mouseDefinition, int delay) throws Exception {
        hover();
        page.mouseDown(mouseDefinition);
        if (delay > 0) {
            TimeUnit.MILLISECONDS.sleep(delay);
        }
        page.mouseUp(mouseDefinition);
    }

    @Override
    public void tap(int delay) throws Exception {
        Coordinate center = getCenter();
        page.touchStart(center.getX(), center.getY());
        if (delay > 0) {
            TimeUnit.MILLISECONDS.sleep(delay);
        }
        page.touchEnd();
    }

    @Override
    public void input(String text, int delay) throws Exception {
        focus();
        for(char chr : text.toCharArray()) {
            String chrStr = String.valueOf(chr);
            USKeyboardDefinition def = USKeyboardDefinition.find(chrStr);
            if (def != null) {
                page.press(def, 0);
            } else {
                insertText(chrStr);
            }
            if (delay > 0) {
                TimeUnit.MILLISECONDS.sleep(delay);
            }
        }
    }

    @Override
    public void select(String... values) throws Exception {
        CallArgument parent = new CallArgument();
        parent.setObjectId(objectId);
        CallArgument argValues = new CallArgument();
        argValues.setValue(values);
        frame.evaluate(SCRIPT_SELECT, false, parent, argValues);
    }
}
