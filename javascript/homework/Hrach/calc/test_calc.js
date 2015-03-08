describe('Calculator testing',function() {
        it('test_add1', function() {
            expect(add(1, 2)).toEqual(3);
        });

        it('test_add2', function() {
            expect(add(-1, 2)).toEqual(1);
        });

		it('test_subtract1', function() {
            expect(subtract(5, 2) > 2).toBeTruthy();
        });

		it('test_subtract2', function() {
            expect(subtract(-1, 2) < -3.1).toBeFalsy();
        });

        it('test_multiply1', function() {
            expect(multiply(-5, 6)).toBeLessThan(-29);
        });

        it('test_multiply2', function() {
            expect(multiply(5, 2)).toBeGreaterThan(0);
        });

        it('test_divide1', function() {
            expect(divide(5, 0)).toBeDefined();
        });

        it('test_divide2', function() {
            expect(divide(10, 6)).toBeCloseTo(1.667, 3);
        });
});
