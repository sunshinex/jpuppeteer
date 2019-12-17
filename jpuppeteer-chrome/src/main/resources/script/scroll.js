function elementScroll(element, x, y) {
    if (element === null || element === undefined) {
        element = window;
    }
    element.scroll({
        left: x,
        top: y,
        behavior: 'instant'
    });
    return {
        scrollX: element.scrollX,
        scrollY: element.scrollY
    };
}