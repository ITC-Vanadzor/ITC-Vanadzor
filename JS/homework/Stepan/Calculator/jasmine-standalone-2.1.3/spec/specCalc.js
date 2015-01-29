describe ("Test maths operations",function (){
    it("test for add ",function(){
      expect(5).toEqual(add(2,3)); 
    });
    it("test for minus ",function(){
      expect(minus(6,5)).toEqual(1); 
    });
    it("test for mutiple ",function(){
      expect(6).toEqual(multiple(2,3)); 
    });
    it("test for division",function(){
      expect(4).toEqual(division(8,2)); 
    });
    it('test for add2', function() {
      expect(add(-1, 2)).toEqual(1);
    });
    it('test for minus 2', function() {
      expect(minus(5, 2) > 2).toBeTruthy();
    });
    it('test for minus 3', function() {
      expect(minus(-1, 2) < -3.1).toBeFalsy();
    });
    it('test for multipe 2', function() {
      expect(multiple(-5, 6)).toBeLessThan(-29);
    });
    it('test for multiple 3', function() {
      expect(multiple(5, 2)).toBeGreaterThan(0);
    });
    it('test division 2', function() {
      expect(division(5, 0)).toBeDefined();
    });
    it("test for add 3", function() {
      expect(add("string", 5)).toEqual(NaN);
    });
    it("test for add 4", function() {
      expect(add(4, "String")).toEqual(NaN);
    });
    it("This tests. is it parseint ",function(){
      expect(parseInt(5)).toBeTruthy(); 
    });
    it("This tests. is it string ",function(){
      expect(parseInt(("String"))).toBeFalsy(); 
    });
    it('It test. is it not string', function () {
        expect(parseInt()).toBeFalsy();
    });
});
