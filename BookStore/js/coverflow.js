var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    coverflow: {
      rotate: 25,
      stretch: 0,
      depth: 200,
      modifier: 1,
      slideShadows : true
    },
    loop: false
  });