package jpuppeteer.chrome.event.type;

public enum ChromeBrowserEvent {

    ;

    private String name;

    private Class clazz;

    ChromeBrowserEvent(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public <T> T getObject(Object object) {
        if (clazz == null) {
            return null;
        } else if (!clazz.equals(object.getClass())) {
            throw new RuntimeException("can not cast " + object.getClass() + " to " + clazz);
        } else {
            return (T) object;
        }
    }

}
