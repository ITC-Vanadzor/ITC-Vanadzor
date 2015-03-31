casper.test.begin('The heading exists', 36, function suite(test) {
    casper.start('http://localhost/Lunch/orderpage.html', function() {
        test.assertTitle('Let\'s have tasty break', 'Title is exist');
        test.assertTitleMatch(/Let\'s have tasty break/, 'Ok');
        test.assertExists('head');
        test.assertExists('head > meta');
        test.assertExists('head > link');
        test.assertElementCount('link', 2);
        test.assertExists('head > script');
        test.assertExists('head > title');
        test.assertSelectorHasText('title', 'Let\'s have tasty break');
	test.assertElementCount('div', 6);
 	test.assertElementCount('input', 2);
	test.assertHttpStatus(200, 'Successfully opened page.');
	test.assertUrlMatch(/^http:\/\//, 'localhost is served in http://');
        test.assertExists('body[onload="getOrderList(),getPlaces()"]');
        test.assertExists('div#main');
	test.assertExists('form[name="orders"]');
        test.assertExists('form>div#placesDiv');
        test.assertExists('form>div > select');
	test.assertExists('form>div > select#places');
        test.assertExists('form>div#productsDiv');
        test.assertExists('div>input');
	test.assertExists('div>input[id="products"]');
   	test.assertExists('div>input[type="text"]');
	test.assertExists('div>input[placeholder="Type product name"]');
	test.assertExists('div>input[onkeyup="setTimeout(function() { loadproducts(); }, 1500)"]');
	test.assertExists('div#product_list');
        test.assertExists('div#countDiv');
	test.assertExists('div>input[min="1"]');
        test.assertExists('div>input[id="count"]');
   	test.assertExists('div>input[type="number"]');
	test.assertExists('div>input[placeholder="Input count"]');
        test.assertExists('form>button');
	test.assertExists('form>button[id="addButton"]');
   	test.assertSelectorHasText('form>button', 'Add');
	test.assertExists('div#table');
        test.assertExists('div#table', "empty");
	                   
    }).run(function() {
        test.done();
    });

});


 

