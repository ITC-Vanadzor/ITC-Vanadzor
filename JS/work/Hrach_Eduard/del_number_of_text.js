function berlin() {
    var text = document.getElementById('h2').innerHTML;
    var text = text.replace(/\d/g, '');
    document.write(text);
}
