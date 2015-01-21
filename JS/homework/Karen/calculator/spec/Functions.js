describe('JavaScript addition operator', function () {
    it('adds one integer', function () {
        expect(isInt(4)).toBe(true);
    });
    it('adds one string', function () {
        expect(isInt("string")).toBe(false);
    });
    it('adds one string', function () {
        expect(isInt()).toBe(true);
    });
});