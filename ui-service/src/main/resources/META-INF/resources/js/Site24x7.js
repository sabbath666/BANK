var rumMOKey='c803ebe14d44f44a4270f85960b39c46';
(function(){
    if(window.performance && window.performance.timing && window.performance.navigation) {
        var site24x7_rum_beacon=document.createElement('script');
        site24x7_rum_beacon.async=true;
        site24x7_rum_beacon.setAttribute('src','//static.site24x7rum.com/beacon/site24x7rum-min.js?appKey='+rumMOKey);
        document.getElementsByTagName('head')[0].appendChild(site24x7_rum_beacon);
    }
})(window)