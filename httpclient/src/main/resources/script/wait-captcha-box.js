function waitCaptchaBox(box) {
    let node = document.querySelector(box);
    if (!node) {
        return;
    }
    let lang = node.getAttribute('data-nc-lang');
    if (!lang) {
        return;
    }
    lang = lang.trim();
    if (lang == "_yesTEXT") {
        return { status: "OK", text: node.innerText };
    } else if (lang == "_startTEXT") {
        return { status: "READY", text: node.innerText };
    } else if (lang.startsWith("_error")) {
        return { "status": "ERROR", text: node.innerText };
    }
}