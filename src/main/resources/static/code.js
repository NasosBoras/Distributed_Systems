function getStuff(res, divID,labels){

            var divElem = document.getElementById(divID);
            for (let i = divElem.childNodes.length - 1; i >= 0; i--) {
                divElem.removeChild(divElem.childNodes[i]);
            }
            for (var i = 0; i < res.length; i++) {
                var obj = res[i];
                if (!obj.tasks) {
                    obj.tasks = "";
                }
                var teacher = obj
                let j = 1;
                for (let index = 0; index < teacher.length; index++) {
                    var element = teacher[index];
                    var input = document.createElement('input');
                    if(element == null){
                        element = "";
                    }
                    var text = document.createTextNode(element);
                    if (index == 0) {
                        div2 = document.createElement('div');
                        div2.style.display = 'none';
                        div2.appendChild(text);
                        input = div2;
                        
                    } else {
                        input.value = text.textContent;
                        var label = document.createTextNode(labels[j]);


                        divElem.appendChild(label);
                        j++;
                    }
                    divElem.appendChild(input);
                }

                divElem.appendChild(document.createElement('br'));
            }
        }