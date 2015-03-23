casper.test.begin('The heading exists', 25, function suite(test) {
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
	test.assertExists('div>table[border="1"]');
        test.assertSelectorHasText('tr>th', 'Place');
	test.assertSelectorHasText('tr>th', 'Distributor');
   	test.assertSelectorHasText('tr>td>a', 'Tashir');
	test.assertSelectorHasText('tr>td>a', 'Valod');
	test.assertExists('tr>td>a[id="tashir"]');
	test.assertExists('tr>td>a[id="valod"]');
        test.assertExists('tr>td>a[href="placespage.html"]');
//	test.assertExists('tr>td>a[onclick="changePlaceName('Tashir')"]');
//      test.assertExists('tr>td>a[onclick="changePlaceName('Valod')"]');
	                   
    }).run(function() {
        test.done();
    });

});


 

