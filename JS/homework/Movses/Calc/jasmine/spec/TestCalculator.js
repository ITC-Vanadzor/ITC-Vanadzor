describe("Calculator test", function() {
    it("plus test true sum", function() {
		expect(plus(2,1)).toEqual(3);
	});
	it("plus test", function() {
		expect(plus("y",5)).toEqual(NaN);
	});
	it("minus test", function() {
		expect(minus(0.3,0.2)).toEqual(0.1);
	});
	it("minus test", function() {
		expect(minus(-4,5)).toBe(-9);
	});
	it("minus test", function() {
		expect(minus(4,"v")).toEqual(NaN);
	});
	it("multi test", function() {
		expect(multi(4,-5)).toBe(-20);
	});
	it("multi test", function() {
		expect(multi(-5,"m")).toEqual(NaN);
	});
	it("div test", function() {
		expect(div(20,5)).toBe(4);
	});
	it("div test", function() {
		expect(div(-5,1)).toBe(-5);
	});
	it("div test", function() {
		expect(div(-5,0)).toBeDefined();
	});
	it("div test", function() {
		expect(div(-5,"m")).toEqual(NaN);
	});
});
