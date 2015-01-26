describe("Calculator test", function() {
    it("plus test", function() {
		expect(plus(2,1)).toEqual(3);
	});
	it("plus test", function() {
		expect(plus(-2,3)).toBe(1);
	});
	it("plus test", function() {
		expect(plus(y,5)).toBe(NaN);
	});
	it("plus test", function() {
		expect(plus(4,z)).toBe(NaN);
	});
	it("minus test", function() {
		expect(minus(0.3,0.2)).toBe(0.1);
	});
	it("minus test", function() {
		expect(minus(-4,5)).toBe(-9);
	});
	it("minus test", function() {
		expect(minus(u,5)).toBe(NaN);
	});
	it("minus test", function() {
		expect(minus(4,v)).toBe(NaN);
	});
	it("times test", function() {
		expect(times(5,1)).toBe(5);
	});
	it("times test", function() {
		expect(times(4,-5)).toBe(-20);
	});
	it("times test", function() {
		expect(times(-5,1)).toBe(-5);
	});
	it("times test", function() {
		expect(times(-5,-1)).toBe(5);
	});
	it("times test", function() {
		expect(times(-5,m)).toBe(NaN);
	});
	it("times test", function() {
		expect(times(v,-1)).toBe(NaN);
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
		expect(div(-5,m)).toBe(NaN);
	});
	it("div test", function() {
		expect(div(j,1)).toBe(NaN);
	});
});
