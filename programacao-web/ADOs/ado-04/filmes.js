function Filme(titulo, categoria, sinopse, nomeImagem) {
    this.titulo = titulo;
    this.categoria = categoria;
    this.sinopse = sinopse;
    this.nomeImagem = nomeImagem;

    this.desenhar = function () {
        var self = this;
        var containerGeral = document.querySelector(".container");

        var container = _createElement("div");
        container.classList.add("container-filme", "bg-padrao", self.categoria);

        var imagem = _createElement("img");
        imagem.src = "imagens/" + self.nomeImagem;

        var center = _createElement("center");
        center.appendChild(imagem);

        var titulo = _createElement("p");
        titulo.classList.add("titulo");
        titulo.textContent = self.titulo;

        var sinopse = _createElement("p");
        sinopse.classList.add("sinopse");
        sinopse.textContent = self.sinopse;

        container.appendChild(center);
        container.appendChild(titulo);
        container.appendChild(sinopse);

        containerGeral.appendChild(container);
    }
    
    function _createElement(nome) { return document.createElement(nome); }
}

var filmes = [];

filmes.push(new Filme("Save Private Ryan (1998)", "drama", "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", "save_private_ryan.jpg"));
filmes.push(new Filme("Fight Club (1999)", "drama", "An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more.", "fight_club.jpg"));
filmes.push(new Filme("The Lord of the Rings: The Fellowship of the Ring (2001)", "aventura", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle Earth from the Dark Lord Sauron.", "lord_of_the_rings.jpg"));
filmes.push(new Filme("Eternal Sunshine of the Spotless Mind (2004)", "romance", "When their relationship turns sour, a couple undergoes a procedure to have each other erased from their memories. But it is only through the process of loss that they discover what they had to begin with.", "eternal_sunshine.jpg"));
filmes.push(new Filme("Batman Begins (2005)", "aventura", "After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.", "batman_begins.jpg"));
filmes.push(new Filme("The Departed (2006)", "aventura", "An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.", "the_departed.jpg"));
filmes.push(new Filme("Into the Wild (2007)", "drama", "An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.", "into_the_wild.jpg"));
filmes.push(new Filme("Inglourious Basterds (2009)", "drama", "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.", "inglorious_basterds.jpg"));
filmes.push(new Filme("Inception (2010)", "scifi", "A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.", "inception.jpg"));
filmes.push(new Filme("The Wolf of Wall Street (2013)", "comedia", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", "wolf_of_wall_street.jpg"));
filmes.push(new Filme("Interstellar (2014)", "scifi", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "interstellar.jpg"));
filmes.push(new Filme("You Don't Mess with the Zohan (2008)", "comedia", "An Israeli Special Forces Soldier fakes his death so he can re-emerge in New York City as a hair stylist.", "zohan.jpg"));

for (var i in filmes) {
    filmes[i].desenhar();
}