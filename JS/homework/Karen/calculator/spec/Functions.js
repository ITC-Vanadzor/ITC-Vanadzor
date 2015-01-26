describe('JavaScript addition operator', function () {

	//isInt
    it('adds one integer', function () {
        expect(isInt(4)).toBeTruthy();
    });  
    it('adds one string', function () {
        expect(isInt("string")).toBeFalsy();
    });
    it('empty paraps', function () {
        expect(isInt()).toBeFalsy();
    });

    //keyboardParser
	it('adds one true order', function () {
        expect(keyboardParser(96)).toEqual(0);
    });    
    it('adds one false order', function () {
        expect(keyboardParser(555)).toBeFalsy();
    });     it('adds one false order', function () {
        expect(keyboardParser(555)).toBeFalsy();
    });  
    it('adds C', function () {
        expect(keyboardParser(46)).toEqual("C");
    });  
});