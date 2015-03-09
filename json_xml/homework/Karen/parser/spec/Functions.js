describe('Json and xml parser test', function () {

    it('Test for Json', function () {
        jsonObject = jsonParser("data/json.json");
        text = "glossary.title";
        elem = getElementJson(jsonObject,text);        
        expect(elem).toEqual("example glossary");
    });
    
});