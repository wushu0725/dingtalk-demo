/**
 * Created by xiangwenwen on 2017/2/9.
 */


export function parseCorpId(url, param) {
    var searchIndex = url.indexOf('?');
    var searchParams = url.slice(searchIndex + 1).split('&');
    for (var i = 0; i < searchParams.length; i++) {
        var items = searchParams[i].split('=');
        if (items[0].trim() == param) {
            return items[1].trim();
        }
    }
}


export default {
    parseCorpId: parseCorpId
}
