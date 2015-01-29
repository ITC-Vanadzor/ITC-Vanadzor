describe("Counter test", function() {
    it("sum test1", function() {
        expect(calc('+',7 ,6)).toEqual(13);
    });
    it("difference test2", function() {
        expect(calc('-',7 ,6)).toEqual(1);
    });
    it("multiply test3", function() {
        expect(calc('*',7 ,6)).toEqual(42);
    });
    it("division test4", function() {
        expect(calc('/',42 ,6)).toEqual(7);
    });
    it("input validation test5", function() {
        expect(isValidInput('mn', 6)).toBeFalsy();
    });
    it("input validation test5", function() {
        expect(isValidInput('mn', 'fvf')).toBeFalsy();
    });
    it("input validation test5", function() {
        expect(isValidInput(8, 'sds')).toBeFalsy();
    });
    it("input validation test5", function() {
        expect(isValidInput(8, 6)).toBeTruthy();
    });
});
