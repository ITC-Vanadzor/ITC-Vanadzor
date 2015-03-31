casper.test.begin('The heading exists', 21, function suite(test) {
    casper.start('http://localhost/Lunch/distributorpage.html', function() {
        test.assertTitle('Distributor', 'Title is exist');
        test.assertTitleMatch(/Distributor/, 'Ok');
        test.assertExists('head');
        test.assertExists('head > meta');
        test.assertExists('head > link');
        test.assertElementCount('link', 2);
        test.assertExists('head > script');
        test.assertExists('head > title');
        test.assertSelectorHasText('title', 'Distributor');
	test.assertElementCount('div', 2);
 	test.assertHttpStatus(200, 'Successfully opened page.');
	test.assertUrlMatch(/^http:\/\//, 'localhost is served in http://');
        test.assertExists('div#distributorMainField');
 	test.assertExists('div.clearfix');
 	test.assertExists('div#distributors');
	test.assertExists('div>table');
        test.assertExists('div>table.table');
	test.assertExists('div>table#distrTable');
        test.assertSelectorHasText('tr>th', 'Place');
	test.assertSelectorHasText('tr>th', 'Distributor');
   	test.assertSelectorHasText('tr>td>a', 'Jazz');
   }).run(function() {
        test.done();
   });
});

casper.thenEvaluate(function(term) {
}, 'CasperJS');
casper.then(function() {
    this.click('tr>td>a#Jazz');
});
casper.then(function() {
    console.log('PASS clicked ok, new location is ' + this.getCurrentUrl());
});
casper.run();

