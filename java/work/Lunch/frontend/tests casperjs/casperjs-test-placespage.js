casper.test.begin('The heading exists', 27, function suite(test) {
    casper.start('http://localhost/Lunch/placespage.html', function() {
        test.assertTitle('Orders', 'Title is exist');
        test.assertTitleMatch(/Orders/, 'Ok');
        test.assertExists('head');
        test.assertExists('head > meta');
        test.assertExists('head > link');
        test.assertElementCount('link', 2);
        test.assertExists('head > script');
        test.assertExists('head > title');
        test.assertSelectorHasText('title', 'Orders');
	test.assertElementCount('div', 4);
        test.assertHttpStatus(200, 'Successfully opened page.');
	test.assertUrlMatch(/^http:\/\//, 'localhost is served in http://');
        test.assertExists('body[onload="changeName(); addProductList();  addUserList()"]');
        test.assertExists('div#distributorMainField');
	test.assertExists('div.clearfix');	
        test.assertExists('h1#placeName');
        test.assertExists('div#productList1');
        test.assertExists('table#productTable');
	test.assertExists('table.table');
 	test.assertSelectorHasText('tr', 'ProductList');
        test.assertSelectorHasText('tr > td > h5', 'Product');
        test.assertSelectorHasText('tr > td > h5', 'Count');
        test.assertSelectorHasText('tr > td > h5', 'Name');
        test.assertExists('div.productList2');
        test.assertExists('table#nameTable');
        test.assertExists('table#orderTable');
        test.assertElementCount('div > table', 3);

    }).run(function() {
        test.done();
    });

});





