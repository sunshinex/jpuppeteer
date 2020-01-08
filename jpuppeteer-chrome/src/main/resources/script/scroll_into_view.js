async function scrollIntoView() {
    const self = this;
    const visibleRatio = await new Promise(resolve => {
        const observer = new IntersectionObserver(entries => {
            resolve(entries[0].intersectionRatio);
            observer.disconnect();
        });
        observer.observe(self);
    });
    if (visibleRatio !== 1.0) {
        self.scrollIntoView({
            block: 'center',
            inline: 'center',
            behavior: 'instant'
        });
    }
}