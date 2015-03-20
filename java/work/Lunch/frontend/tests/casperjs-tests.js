casper.test.begin('The heading exists', 8, function suite(test) {
    casper.start('http://localhost', function() {
        test.assertExists('h1.page-title');
        test.assertExists('div.testid');
        test.assertSelectorHasText('h1.page-title', 'Hello');
        test.assertSelectorHasText('div.testid', 'test');
        test.assertVisible('footer');
        test.assertVisible('li');
        test.assertVisible('ul');
        test.assertTitle("My page", "title is exist");
    }).run(function() {
        test.done();
    });
});

