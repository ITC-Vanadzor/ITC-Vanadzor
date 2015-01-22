describe("Calculator test", function() {
	it("plus test", function() {
		expect(plus(4,5)).toEqual(9);
	});
	it("plus test", function() {
		expect(plus(-4,5)).toEqual(1);
	});
	it("plus test", function() {
		expect(plus(a,5)).toEqual(NAN);
	});
	it("plus test", function() {
		expect(plus(4,b)).toEqual(NAN);
	});
	it("minus test", function() {
		expect(minus(4,5)).toEqual(-1);
	});
	it("minus test", function() {
		expect(minus(-4,5)).toEqual(-9);
	});
	it("minus test", function() {
		expect(minus(k,5)).toEqual(NAN);
	});
	it("minus test", function() {
		expect(minus(4,v)).toEqual(NAN);
	});
	it("umn test", function() {
		expect(umn(5,1)).toEqual(5);
	});
	it("umn test", function() {
		expect(umn(4,-5)).toEqual(-20);
	});
	it("umn test", function() {
		expect(umn(-5,1)).toEqual(-5);
	});
	it("umn test", function() {
		expect(umn(-5,-1)).toEqual(5);
	});
	it("umn test", function() {
		expect(umn(-5,m)).toEqual(NAN);
	});
	it("umn test", function() {
		expect(umn(v,-1)).toEqual(NAN);
	});
	it("del test", function() {
		expect(del(20,5)).toEqual(4);
	});
	it("del test", function() {
		expect(del(-5,1)).toEqual(-5);
	});
	it("del test", function() {
		expect(del(-5,0)).toBeDefined();
	});
	it("del test", function() {
		expect(del(-5,m)).toEqual(NAN);
	});
	it("del test", function() {
		expect(del(j,1)).toEqual(NAN);
	});
});
