
const getXssUrl = 'http://localhost:4200/getXSS';

httpGet(appendLoop, getXssUrl);

function jsRBUpdate(rb) {
  const xssId = rb.id.split("rb_")[1];
  httpGet(handleGetById, getXssUrl + '/' + xssId)
}

function handleGetById(jsonObj) {
  console.log(jsonObj);

  let element = document.getElementById("divJsByIdPlaceholder");
  cleanAllChildren(element);

  var c = document.createElement('span');
  c.innerHTML = jsonObj.text;
  console.log(c);
  element.appendChild(c);
}


function appendLoop(jsonObj) {
  console.log(jsonObj.length);

  let element = document.getElementById("divJsPlaceholder");
  cleanAllChildren(element);

  for(let i=0; i < jsonObj.length; i++) {
    var c = document.createElement('span');
    c.innerHTML = jsonObj[i].text;
    console.log(c);
    element.appendChild(c)
  }
}

function httpGet(handler, theUrl) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function() {
    if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
      handler(JSON.parse(xmlHttp.responseText));
  }
  xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
  xmlHttp.send( null );
}

function cleanAllChildren(element) {
  for(i = 0; i < element.children.length; i++){
    element.children[i].remove();
  }
}
