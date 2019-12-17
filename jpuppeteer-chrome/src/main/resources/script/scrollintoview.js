async function scrollIntoView(element) {
    const visibleRatio = await new Promise(resolve => {
        const observer = new IntersectionObserver(entries => {
            resolve(entries[0].intersectionRatio);
            observer.disconnect();
        });
        observer.observe(element);
    });
    if (visibleRatio !== 1.0) {
        element.scrollIntoView({
            block: 'center',
            inline: 'center',
            behavior: 'instant'
        });
    }
}