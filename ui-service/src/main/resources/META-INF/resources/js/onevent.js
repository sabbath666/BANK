function onevent(data,name) {
    var status = data.status; // Can be "begin", "complete" or "success".

    switch (status) {
        case "begin": // Before the ajax request is sent.
            PF(name).show();
            break;

        case "complete": // After the ajax response is arrived.
            PF(name).hide();
            break;

        case "success": // After update of HTML DOM based on ajax response..
            // ...
            break;
    }
}