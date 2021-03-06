
const getXssUrl = '/api/experience/xss/getXSS';

httpGet(appendLoop, getXssUrl);

function jsRBUpdate(rb) {
  const xssId = rb.id.split("rb_")[1];
  httpGet(handleGetById, getXssUrl + '/' + xssId)
}

function handleGetById(jsonObj) {
  let element = document.getElementById("divJsByIdPlaceholder");
  cleanAllChildren(element);

  var c = document.createElement('span');
  c.innerHTML = jsonObj.text;
  element.appendChild(c);
}


function appendLoop(jsonObj) {
  let element = document.getElementById("divJsPlaceholder");
  cleanAllChildren(element);

  for(let i=0; i < jsonObj.length; i++) {
    var c = document.createElement('span');
    c.innerHTML = jsonObj[i].text;
    element.appendChild(c)
  }
}

function httpGet(handler, theUrl) {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function() {
    if (xmlHttp.readyState === 4 && xmlHttp.status === 200)
      handler(JSON.parse(xmlHttp.responseText));
  }
  xmlHttp.open( "GET", theUrl, false);
  xmlHttp.setRequestHeader('Authorization', 'Basic YWRtaW46YWRtaW4=');
  xmlHttp.send( null);
}

function cleanAllChildren(element) {
  for(i = 0; i < element.children.length; i++){
    element.children[i].remove();
  }
}
