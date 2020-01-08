async function isIntersectingViewport(element) {
    const visibleRatio = await new Promise(resolve => {
        const observer = new IntersectionObserver(entries => {
            resolve(entries[0].intersectionRatio);
            observer.disconnect();
        });
        observer.observe(element);
    });
    return visibleRatio > 0;
}