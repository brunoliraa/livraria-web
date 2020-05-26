carouselSlider()
{
    var self = this;
    this.slider = $(this.carousel);

    $(document).ready(function () {
        $('.carousel').carousel({
            interval: 5000,
            pause: false
        })

        for (let j = 0; j < self.edicao.imagens.length; j++) {
            let image = self.edicao.imagens[j];
            $('<div class="carousel-item"><img src=' + image + ' width="50%">   </div>').appendTo('.carousel-inner');
            $('<li data-target="#carousel" data-slide-to="' + j + '"></li>').appendTo('.carousel-indicators')
        }

        $('.carousel-item').first().addClass('active');
        $('.carousel-indicators > li').first().addClass('active');

        $('a[data-slide="prev"]').click(function () {
            $(self.carousel).carousel('prev');
        });

        $('a[data-slide="next"]').click(function () {
            $(self.carousel).carousel('next');
        });

        self.slider.carousel();
    });
}














// $(document).ready(function(){
//     for(let j = 0; j < 5; j++) {
//         $('<div class="carousel-item"><img
//         src="https://loremflickr.com/320/240" width="50%">
//             </div>').appendTo('.carousel-inner');
//         $('<li data-target="#carousel" data-slide-to="'+j+'">
//             </li>').appendTo('.carousel-indicators')
//
//     }
//
//     $('.carousel-item').first().addClass('active');
//     $('.carousel-indicators > li').first().addClass('active');
//     $('#carousel').carousel();
// });