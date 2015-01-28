describe('My calculator test',function() {
        it('test_add1', function() {
            expect(add(5, 8)).toEqual(13);
        });

        it('test_add2', function() {
	    var a = "a"; 
            expect(add(a, 2)).toEqual("a2");
        });
	it('test_add3', function() {
	   expect(add(-6, 2)).toEqual(-4);
        });
	it('test_add4', function() {
	    var a = true; 
            expect(add(a, 4)).toEqual(5);
        });
	it('test_subtract1', function() {
            expect(subtract(6, 1)).toEqual(5);
        });

	it('test_subtract2', function() {
            expect(subtract(6, 1) > 4).toBe(true);
        });

	it('test_subtract3', function() {
            expect(subtract(-8, 2) > 5).toBe(false);
        });

        it('test_product1', function() {
            expect(product(7,5)).toEqual(35);
        });
	
        it('test_product2', function() {
            expect(product(7, 2)).toBeGreaterThan(0);
        });
	it('test_product3', function() {
            expect(product(10, -2)).toBeGreaterThan(-21);
        });
	it('test_product4', function() {
	    var str = "some"
            expect(product(str, 2)).toBeNaN();
        });

        it('test_divide1', function() {
            expect(divide(8, 0)).toBeDefined();
        });

        it('test_divide2', function() {
            expect(divide(10, 5)).toEqual(2);
        });
	it('test_divide3', function() {
	    var str ="asdf";
            expect(divide(10, str)).toBeNaN();
	});
	/*it ('test_result1', function() {
	    var str = "23+35";
	    expect(result(str)).toBeDefined();
        }); */ 	

});
