#!/usr/bin/python

from xml.dom import minidom
Test_file = open('xml.xml')
xmlDoc = minidom.parse(Test_file)

Test_file.close()

value = raw_input("Please enter your request: ")

def getText(nodelist):
    rc = []
    for node in nodelist:
        if node.nodeType == node.TEXT_NODE:
            rc.append(node.data)
    return ''.join(rc)

def handleXML(glossary):
    handleXMLTitle(glossary.getElementsByTagName("title")[0])

def handleXMLTitle(title):
    print "\n"+getText(title.childNodes)
    
def handleXMLGlossDiv(GlossDiv):
    handleXMLTitle2(GlossDiv.getElementsByTagName("title")[1])
         
def handleXMLTitle2(title):
    print "\n"+getText(title.childNodes)

def handleXMLGlossTerm(GlossEntry):
    handleXMLTitle3(GlossEntry.getElementsByTagName("GlossTerm")[0])

def handleXMLiAcronym(GlossEntry):
    handleXMLTitle4(GlossEntry.getElementsByTagName("Acronym")[0])

def handleXMLAbbrev(GlossEntry):
    handleXMLTitle5(GlossEntry.getElementsByTagName("Abbrev")[0])

def handleXMLpara(GlossDef):
    handleXMLTitle6(GlossDef.getElementsByTagName("para")[0])
    
def handleXMLTitle6(para):
    print "\n"+getText(para.childNodes)         

def handleXMLTitle3(GlossTerm):
    print "\n"+getText(GlossTerm.childNodes)

def handleXMLTitle5(Abbrev):
    print "\n"+getText(Abbrev.childNodes)
    
def handleXMLTitle4(Acronym):
    print "\n"+getText(Acronym.childNodes)
    
if (value == "glossary.GlossDiv.GlossList.GlossEntry.GlossTerm"):
    handleXMLGlossTerm(xmlDoc)

if (value == "glossary.GlossDiv.GlossList.GlossEntry.GlossDef.para"):
    handleXMLpara(xmlDoc)

if (value == "glossary.GlossDiv.GlossList.GlossEntry.Acronym"):
    handleXMLAcronym(xmlDoc)

if (value == "glossary.GlossDiv.GlossList.GlossEntry.Abbrev"):
    handleXMLAbbrev(xmlDoc)

if (value == "glossary.title"):
    handleXML(xmlDoc)

if (value == "glossary.GlossDiv.title"):
    handleXMLGlossDiv(xmlDoc)


def main():
    pass
        
if "__main__"==__name__:       
    main()    

