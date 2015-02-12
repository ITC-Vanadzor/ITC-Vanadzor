function get_xml(filename){
    xmlhttp=new XMLHttpRequest();
    xmlhttp.open("GET",filename,false);
    xmlhttp.send();
    xmlDoc=xmlhttp.responseXML;
    return xmlDoc;
}

function print_content(filename){
    xmlDoc = get_xml(filename);
    //document.getElementById("content").appendChild(xmlDoc);
    var xmlText = new XMLSerializer().serializeToString(xmlDoc);
    var xmlTextNode = document.createTextNode(xmlText);
    var parentDiv = document.getElementById('content');
    parentDiv.appendChild(xmlTextNode);
}
function print_tag(tag_name){
    var xmlText = new XMLSerializer().serializeToString(xmlDoc.getElementsByTagName(tag_name)[0]);
    var xmlTextNode = document.createTextNode(xmlText);
    var parentDiv = document.getElementById('answer');
    parentDiv.appendChild(xmlTextNode);

}
function build_path_array(path){
    var path_array = path.split('.');
    return path_array;
}

function is_root(xmlDoc,first_el){
    if (xmlDoc.getElementsByTagName(first_el)[0]){
        return true;
    }
    else 
        return false;    
}
function is_child(parent_elem, child_elem){
    if (parent_elem.hasChildNodes()){
        var child_list = parent_elem.childNodes;
        for (i=0; i< child_list.length; i++){
            if (child_elem == child_list[i]){
                return true;
            }
        }
    }     
   return false;
}
function check_path(path_array){
    var message = document.getElementById("answer");
    var xmlDoc = get_xml("work1.xml");
    first_el = path_array[0];
    if (is_root(xmlDoc, first_el)){
        if(path_array.length == 1){
            return true;
        }
        else{
            for(i=0; i<path_array.length-1; i++){
                try{
                    if (!is_child(xmlDoc.getElementsByTagName(path_array[i])[0],xmlDoc.getElementsByTagName(path_array[i+1])[0])) {
                        throw path_array[i+1]+"isn't"+path_array[i]+"'s child";
                        return false;
                    }                                         
                }
                catch(err){
                    message.innerHTML = err;
                }
             }
             return true;
        }
    }
    else{
        message.innerHTML = path_array[0]+"empty or isn't valid";
        return false;
    }   
}
function get_element(path){
    var path_array= path.split('.');
    var message = document.getElementById("answer");
    var doc =  get_xml('work1.xml');
    var last_tag_name = doc.getElementsByTagName(path_array[path_array.length-1])[0];
    var path_last = path_array[path_array.length-1].split(':');
    var last_elem = doc.getElementsByTagName(path_last[0])[0]; 
    //var element = doc.getElementsByTagName(path_array[0])[0];
    if (path_last.length == 1){
        if (check_path(path_array)){
             // message.innerHTML = last_tag_name.childNodes[0].nodeValue;
             print_tag(path_last[0]);
        }
   }

    else  {
        path_array[path_array.length-1]=path_last[0];
        if(check_path(path_array)){
            if ( last_elem.hasAttribute(path_last[1])){
                 message.innerHTML = last_elem.getAttribute(path_last[1]);
            }
            else{
                message.innerHTML = "there is no"+path_last[1]+" attribute";
            }
        }
        else{
            message.innerHML = "error!!!!";
        }
    }   
}
