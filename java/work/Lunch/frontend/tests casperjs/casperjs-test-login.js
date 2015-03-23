casper.test.begin('The heading exists', 35, function suite(test) {
    casper.start('http://localhost/Lunch/loginpage.html', function() {
        test.assertTitle('Log In', 'Title is exist');
        test.assertTitleMatch(/Log In/, 'Ok');
        test.assertExists('head');
        test.assertExists('head > meta');
        test.assertExists('head > link');
        test.assertElementCount('link', 2);
        test.assertExists('head > script');
        test.assertExists('head > title');
        test.assertSelectorHasText('title', 'Log In');
	test.assertElementCount('div', 9);
        test.assertExists('div#test');
        test.assertExists('div.loginbox');
        test.assertExists('div > center');
        test.assertSelectorHasText('div > center', 'Sign in');
        test.assertExists('div#login-content');
        test.assertExists('center');
        test.assertExists('center#errormsg');
        test.assertElementCount('div.login-component', 2);
        test.assertExists('div.login-component>input[type="email"]');
        test.assertExists('div.login-component>input[id="email"]');
   	test.assertExists('div.login-component>input[placeholder="Email"]');
	test.assertExists('div.login-component>input[required]');
 	test.assertExists('div > input');
        test.assertElementCount('input', 4);
        test.assertExists('div.login-component>input[type="password"]');
        test.assertExists('div.login-component>input[id="pswd"]');
   	test.assertExists('div.login-component>input[placeholder="Password"]');
        test.assertExists('div#checkbox>input[type="checkbox"]');
	test.assertSelectorHasText('div#checkbox', 'Remember me');
	test.assertExists('div#botton');
	test.assertExists('div#botton>input[value="Sign in"]');
	test.assertExists('div#botton>input[type="button"]');
	test.assertExists('div#botton>input[onclick="return login()"]');
        test.assertHttpStatus(200);
        test.assertUrlMatch(/^http:\/\//, 'localhost is served in http://');
                        
    }).run(function() {
        test.done();
    });

});


 //     test.assertSelectorHasText('div > input', 'Remember me');


