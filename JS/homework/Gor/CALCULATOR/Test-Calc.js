/* Copyright Gor Julhakyan ** 2015 ** */

/*JavaScript Document*/


describe('JavaScript addition operator', function () {
	
	// * Test for input is Int & Float only * //
	
	it('Input is Integer', function () {
        expect(isInt(3)).toBeTruthy();
    }); 
	
	it('Input is Float', function () {
        expect(isFloat(3.3)).toBeTruthy();
    }); 
	
    it('Input is Alphabetical', function () {
        expect(isStr("abc")).toBeFalsy();
    });
	
    it('Input is Symbols only', function () {
        expect(isStr(",/-_")).toBeFalsy();
    });
	
    it('Input is Math operators', function () {
        expect(isStr("+, -, /, *, =")).toBeFalsy();
    });
	
	// * Test for Math functions * //

	it('Input is Float', function () {
        expect(add(3.3 + 2.2)).toEqual(5.5);
    }); 
	
	it('Input is Integer', function () {
        expect(add(5 + 3)).toEqual(8);
    }); 
	
});
