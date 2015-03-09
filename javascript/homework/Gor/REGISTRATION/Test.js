/* Copyright Gor Julhakyan ** 2015 ** */

// JavaScript Document

describe("First Name Input", function() {  
    it('Should return false', function() { 
        expect(Fname()).toBeFalsy(); 
    });
    it('Input is Integer', function () {
        expect(isInt(3)).toBeFalsy();
    }); 
    
    it('Input is Nan', function () {
        expect(isNan(Nan)).toBeFalsy();
    }); 
    
	it('Input is Float', function () {
        expect(isFloat(3.3)).toBeFalsy();
    }); 
	
    it('Input is Alphabetical', function () {
        expect(isStr("abc")).toBeTruthy();
    });
});

describe("Last Name Input", function() {  
    it('Should return false', function() { 
        expect(Lname()).toBeFalsy();  
        
    });
    it('Input is Integer', function () {
        expect(isInt(3)).toBeFalsy();
    }); 
    
    it('Input is Nan', function () {
        expect(isNan(Nan)).toBeFalsy();
    }); 
    
	it('Input is Float', function () {
        expect(isFloat(3.3)).toBeFalsy();
    }); 
	
    it('Input is Alphabetical', function () {
        expect(isStr("abc")).toBeTruthy();
    });
});

describe("Last Name Input", function() {  
    it('Should return false', function() { 
        expect(Emial()).toBeFalsy();  
        
    });
    it('Input is only Integer', function () {
        expect(isInt(3)).toBeFalsy();
    }); 
    
    it('Input is only Nan', function () {
        expect(isNan(Nan)).toBeFalsy();
    }); 
    
	it('Input is only Float', function () {
        expect(isFloat(3.3)).toBeFalsy();
    }); 
	
    it('Input is only Alphabetical', function () {
        expect(isStr("abc")).toBeFalsy();
    });
});

describe("Last Name Input", function() {  
    it('Should return false', function() { 
        expect(Password()).toBeFalsy();  
        
    });
    it('Input is only Integer', function () {
        expect(isInt(3)).toBeTruthy();
    }); 
    
    it('Input is only Nan', function () {
        expect(isNan(Nan)).toBeFalsy();
    }); 
    
	it('Input is only Float', function () {
        expect(isFloat(3.3)).toBeTruthy();
    }); 
	
    it('Input is only Alphabetical', function () {
        expect(isStr("abc")).toBeTruthy();
    });
});
