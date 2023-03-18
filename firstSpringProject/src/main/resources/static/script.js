const tbl = document.getElementById("posts");
const url = 'http://localhost:8088/api/v1/posts';
const userId = document.getElementById("kullaniciId").value;

function temizle(){
	 document.getElementById("id").value = "";
	 document.getElementById("baslik").value = "";
	 document.getElementById("mesaj").value = "";
}

function sil() {
    const id = document.getElementById("id").value;

    if (id === "") {
        alert("Silinecek kaydı seçiniz!");
        return;
    }

    fetch(url + '/' + id, {
        method: 'DELETE',
    }).then(response => {
        if (response.status === 200) {
            alert("Silme işlemi başarılı");
        }
    });
}

function guncelle() {
    const id = document.getElementById("id").value;
    const title = document.getElementById("baslik").value;
    const body = document.getElementById("mesaj").value;

    if (id === "") {
        alert("Güncellenecek kaydı seçiniz!");
        return;
    }

    fetch(url + "/" + id, {
        method: 'PUT',
        body: JSON.stringify({
            id: id,
            title: title,
            body: body,
            userId: userId
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .then(()=>veriGetir())
        .then(()=>temizle());
}

function duzenle(id) {
    fetch(url + "/" + id)
        .then((response) => response.json())
        .then((post) => {
            document.getElementById("id").value = post.id;
            document.getElementById("baslik").value = post.title;
            document.getElementById("mesaj").value = post.body;
        });
}

function ekle() {

    const title = document.getElementById("baslik").value;
    const body = document.getElementById("mesaj").value;
    fetch(url, {
        method: 'POST',
        body: JSON.stringify({
            title: title,
            body: body,
            userId: userId,
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        },
    })
        .then((response) => response.json())
        .then((json) => console.log(json));
    
    veriGetir();
}

function veriGetir() {
	tbl.innerHTML = `
	<tr>
            <th>Id</th>
            <th>Title</th>
            <th>Body</th>
            <th>User Id</th>
            <th></th>
        </tr>
	`;
    fetch(url)
        .then((response) => response.json())
        .then((posts) => {
            posts.forEach(post => {
                tbl.innerHTML += `
                        <tr>
                        <td style="text-align:center">${post.id}</td>    
                        <td style="width:30%">${post.title}</td>
                        <td width="40%">${post.body}</td>
                        <td style="text-align:center">${post.userId}</td> 
                        <td><a href="#" onclick=duzenle(${post.id})>Düzenle</a></td>   
                        </tr>
                        `
            });
        });
}

/*
fetch('https://jsonplaceholder.typicode.com/posts/1')
    .then((response) => response.json())
    .then((post) => document.write("<p>" + post.id + "</p><br>" + "<p>" + post.title + "</p><br>"));
*/