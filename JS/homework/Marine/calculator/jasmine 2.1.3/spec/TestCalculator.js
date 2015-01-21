window.alert("aaaaaa")
describe("Calculator test", function() {
it("plus test", function() {
expect(plus(4,5)).toEqual(9);
});
it("plus test", function() {
expect(plus(-4,5)).toEqual(1);
});
it("minus test", function() {
expect(minus(4,5)).toEqual(-1);
});
it("plus test", function() {
expect(minus(5,1)).toEqual(1);
});
it("umn test", function() {
expect(umn(4,5)).toEqual(20);
});
it("umn test", function() {
expect(umn(-5,1)).toEqual(-5);
});
it("del test", function() {
expect(del(4,5)).toEqual(20);
});
it("del test", function() {
expect(del(-5,1)).toEqual(-5);
});
it("del test", function() {
expect(del(-5,0)).toBeDefined();
});
});
