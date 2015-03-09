describe("Calculator test", function() {
	it("plus test1", function() {
		expect(plus(4,5)).toEqual(9);
	});
	it("plus test2", function() {
		expect(plus(-4,5)).toEqual(1);
	});
	it("plus test3", function() {
		expect(type("a")).toBeFalsy();
	});
	it("minus test1", function() {
		expect(minus(4,5)).toEqual(-1);
	});
	it("minus test2", function() {
		expect(minus(-4,5)).toEqual(-9);
	});
	it("minus test3", function() {
		expect(type(".fa")).toBeFalsy();
	});
	it("umn test1", function() {
		expect(umn(5,1)).toEqual(5);
	});
	it("umn test2", function() {
		expect(umn(4,-5)).toEqual(-20);
	});
	it("umn test3", function() {
		expect(umn(-5,1)).toEqual(-5);
	});
	it("umn test4", function() {
		expect(umn(-5,-1)).toEqual(5);
	});
	it("umn test5", function() {
		expect(type("-667fgvba")).toBeFalsy();
	});
	it("del test1", function() {
		expect(del(20,5)).toEqual(4);
	});
	it("del test2", function() {
		expect(del(-5,1)).toEqual(-5);
	});
	it("del test3", function() {
		expect(del(-5,0)).toBeDefined();
	});
	it("del test4", function() {
		expect(type("a")).toBeFalsy();
	});
	
});
