document.addEventListener('DOMContentLoaded', function(ev){
    let css = document.createElement('style');
    css.setAttribute("type", "text/css");
    css.innerText = "iframe {pointer-events: none;}";
    document.head.appendChild(css);
}, false);

document.addEventListener('mousemove', function(ev){
    let node = document.createElement('div');
    node.style='width:2px;height:2px;background:#f00;position:fixed;left:'+(ev.clientX+2)+'px;top:'+(ev.clientY+2)+'px;z-index:99999';
    document.body.appendChild(node);
    setTimeout(function(){
        document.body.removeChild(node);
    }, 100);
}, false);