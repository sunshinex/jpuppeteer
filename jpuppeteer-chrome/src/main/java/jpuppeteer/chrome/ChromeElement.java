package jpuppeteer.chrome;

import jpuppeteer.api.browser.BoundingBox;
import jpuppeteer.api.browser.BoxModel;
import jpuppeteer.api.browser.Coordinate;
import jpuppeteer.api.browser.Element;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.USKeyboardDefinition;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.cdp.entity.dom.FocusRequest;
import jpuppeteer.cdp.cdp.entity.dom.GetBoxModelRequest;
import jpuppeteer.cdp.cdp.entity.dom.GetBoxModelResponse;
import jpuppeteer.cdp.cdp.entity.dom.SetFileInputFilesRequest;
import jpuppeteer.cdp.cdp.entity.input.InsertTextRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.RemoteObject;
import jpuppeteer.chrome.util.ArgUtils;
import jpuppeteer.chrome.util.MathUtils;
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

    private static final String SCRIPT_IS_INTERSECTING_VIEWPORT = ScriptUtils.load("isintersectingviewport.js");

    protected ChromePage page;

    protected ChromeFrame frame;

    protected ChromeElement(ChromeFrame frame, RemoteObject object) {
        super(frame.runtime, frame.executionContext(), object);
        this.frame = frame;
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

    protected ChromeElement(ChromeFrame frame, ChromeBrowserObject object) {
        this(frame, object.object);
    }

    @Override
    public ChromeElement querySelector(String selector) throws Exception {
        CallArgument parent = ArgUtils.createFromObjectId(objectId);
        CallArgument argSelector = ArgUtils.createFromValue(selector);
        ChromeBrowserObject object = frame.evaluate("function(parent, selector){return parent.querySelector(selector);}", parent, argSelector);
        if (RemoteObjectType.UNDEFINED.equals(object.type) || RemoteObjectSubtype.NULL.equals(object.subType)) {
            return null;
        }
        return new ChromeElement(frame, object.object);
    }

    @Override
    public List<ChromeElement> querySelectorAll(String selector) throws Exception {
        CallArgument parent = ArgUtils.createFromObjectId(objectId);
        CallArgument argSelector = ArgUtils.createFromValue(selector);
        ChromeBrowserObject object = frame.evaluate("function(parent, selector){return parent.querySelectorAll(selector);}", parent, argSelector);
        List<ChromeBrowserObject> properties = object.getProperties();
        return properties.stream().map(obj -> new ChromeElement(frame, obj.object)).collect(Collectors.toList());
    }

    @Override
    public ChromeFrame frame() {
        return frame;
    }

    @Override
    public boolean isIntersectingViewport() throws Exception {
        return frame.evaluate(SCRIPT_IS_INTERSECTING_VIEWPORT, Boolean.class, ArgUtils.createFromObjectId(objectId));
    }

    @Override
    public BoundingBox boundingBox() throws Exception {
        BoxModel model = boxModel();
        if (model == null) {
            return null;
        }

        Coordinate[] border = model.getBorder();

        double x = MathUtils.min(border[0].getX(), border[1].getX(), border[2].getX(), border[3].getX());
        double y = MathUtils.min(border[0].getY(), border[1].getY(), border[2].getY(), border[3].getY());

        double width = MathUtils.max(border[0].getX(), border[1].getY(), border[2].getX(), border[3].getX()) - x;
        double height = MathUtils.max(border[0].getY(), border[1].getY(), border[2].getY(), border[3].getY()) - y;
        return new BoundingBox(x, y, width, height);
    }

    @Override
    public BoxModel boxModel() throws Exception {
        GetBoxModelRequest request = new GetBoxModelRequest();
        request.setObjectId(objectId);
        GetBoxModelResponse resp = frame.dom.getBoxModel(request, DEFAULT_TIMEOUT);
        if (resp == null) {
            return null;
        }
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
    public void clear() throws Exception {
        page.evaluate("function(element){element.value='';}", ArgUtils.createFromObjectId(objectId));
    }

    @Override
    public void input(String text, int delay) throws Exception {
        try {
            focus();
        } catch (Exception e) {
            click();
        }
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
        CallArgument parent = ArgUtils.createFromObjectId(objectId);
        CallArgument argValues = ArgUtils.createFromValue(values);
        frame.evaluate(SCRIPT_SELECT, parent, argValues);
    }
}
