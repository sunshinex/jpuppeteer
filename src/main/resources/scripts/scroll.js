function scroll(x, y) {
    this.scroll({
        left: x,
        top: y,
        behavior: 'instant'
    });
}