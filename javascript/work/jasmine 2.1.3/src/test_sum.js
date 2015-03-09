describe('Javascript addition operator',function() {
        it('adds two numbers together', function() {
            expect(sum(1, 2)).toEqual(3);
        });

        it('adds two numbers together', function() {
            expect(sum(-1, 2)).toEqual(1);
        });
});
