function fadeOutBackColor() {
    $('#box').one('click', function () {
        var color = [255, 255, 255].join(',') + ',',
                transparency = 1,
                element = this,
                timeout = setInterval(function () {
                    if (transparency >= 0) {
                        element.style.backgroundColor = 'rgba(' + color + (transparency -= 0.015) + ')';
                    } else {
                        clearInterval(timeout);
                    }
                }, 40);
    });
}