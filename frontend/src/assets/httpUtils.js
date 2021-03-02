httpGet('http://localhost:4200/getXSS');

function appendLoop(jsonObj) {
  console.log(jsonObj.length);
  for(let i=0; i < jsonObj.length; i++) {
    var c = document.createElement('span'); // is a node
    c.innerHTML = jsonObj[i].text;
    console.log(c);
    document.getElementById("divJsPlaceholder").appendChild(c)
  }
}


function httpGet(theUrl) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function() {
    if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
      appendLoop(JSON.parse(xmlHttp.responseText));
  }
  xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
  xmlHttp.send( null );
}
