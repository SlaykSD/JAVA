const arr = [{
        'Стрижка женская': [
            ['Короткие волосы', '500 руб'],
            ['Средняя длинна', '600 руб'],
            ['Длинные', '850-1000 руб'],
            ['Короткие волосы', '300-400 руб']
        ],
        'Стрижка мужская': [
            ['Спортивная', '500 руб'],
            ['Модельная', '400-450 руб'],
            ['Площадка', '500 руб'],
            ['Наголо', '150 руб']
        ],
        'Укладка с использованием укладочных средств (Londa, Estel, Kapous)': [
            ['Короткие волосы', '500 руб'],
            ['Средняя длинна', '600 руб'],
            ['Длинные', '700-1000 руб']
        ],
        'Окраска волос в один цвет(без учёта краски)': [
            ['Короткие волосы ', '500 руб'],
            ['Средняя длинна', '500-600 руб'],
            ['Экстра длинные', '800 руб'],
            ['Длинные', '700 руб']
        ],
        'Мелирование': [
            ['Короткие волосы', '1000 руб'],
            ['Средняя длинна', '1500 руб'],
            ['Длинные', '1800 руб'],
            ['Экстра длинные', '2300-2500 руб']
        ],
        'Колорирование': [
            ['Короткие волосы', '1400 руб'],
            ['Средняя длинна', '2000 руб'],
            ['Длинные', '2600 руб']
        ],
        'Химическая заливка волос': [
            ['Короткие волосы', '1200 руб'],
            ['Средняя длинна', '1600 руб'],
            ['Длинные', '2000 руб']
        ],
        'Свадебные и вечерние прически': [
            ['Короткие волосы', '1800 руб'],
            ['Средняя длинна', '2400 руб'],
            ['Длинные', '1000 руб']
        ],
        'Кератиновое восстановление волос': [
            ['Короткие волосы', '2500 руб'],
            ['Средняя длинна', '3500 руб'],
            ['Длинные', '4500-5500 руб']
        ]

    },
    {

        'Очищение': [
            ['Молочко очищающее ', '50 руб'],
            ['Гель пенящийся', '50 руб'],
            ['Демакияж с глаз', '50 руб']
        ],
        'Глубокое очищение': [
            ['Пилинг на основе молочной кислоты 10% молочный мусс ', '500 руб'],
            ['Энзимный пилинг', '200 руб'],
            ['Ретиноевый пиллинг "inno-pil"', '2000 руб'],
            ['Наголо', '150 руб']
        ],
        'Интенсивный уход': [
            ['Сыворотки для лица', '300-350 руб'],
            ['Сыворотки для век', '300 руб']
        ],
        'Массаж косметический пластический': [
            ['С использованием массажного масла', '500 руб'],
            ['С использованием крем-маски или сыворотки ', '700-750 руб']
        ],
        'Аппаратная косметология': [
            ['Бросаж(щеточный пиллинг)', '150 руб'],
            ['Д\'Арсонваль', '150 руб'],
            ['Фонофорез', '400 руб'],
            ['Микротоковая терапия', '400 руб'],
            ['Ультразвуковой пилинг', '500 руб'],
            ['Механическая чистка', '500 руб'],
            ['Криомассаж', '200 руб']
        ],
        'Маски': [
            ['Крем-маски', '300 руб'],
            ['Пасты', '300 руб'],
            ['Таблетированные маски+концентрат', '300 руб'],
            ['Альгинатные маски для лица', '300 руб'],
            ['Альгинатные маски для глаз и губ', '200 руб']
        ],
        'Защита': [
            ['Нанесение крема', '50 руб'],
            ['Мануальная чистка<br>(Очищение, глубокое очищение, мех. чистка, паста)', 'от 1200 руб'],
            ['Косметический массаж<br>(Очищение, косметический массаж, крем-маска)', 'от 1000 руб'],
            ['Офрмленеи бровей и ресниц<br>Придание формы', '200 руб'],
            ['Офрмленеи бровей и ресниц<brОкраска бровей', '200 руб'],
            ['Офрмленеи бровей и ресниц<br>Окраска ресниц', '200 руб'],
            ['Офрмленеи бровей и ресниц<br>Комплекс', '500 руб'],
            ['Депиляция воском<br>Подбородок', '300 руб'],
            ['Депиляция воском<br>Верхняя губа', '300 руб'],
            ['Депиляция воском<br>Подмышки', '300 руб'],
            ['Депиляция воском<br>Голень', '500 руб'],
            ['Депиляция воском<br>Бедро', '500 руб'],
            ['Депиляция воском<br>Бикини глубокое', '900 руб'],
            ['Депиляция воском<br>Бикини классическое', '600 руб'],
            ['Депиляция воском<br>Руки (предлечье)', '450 руб'],
            ['Прокол ушей', '550 руб'],
            ['Прессотерапия', '350-500 руб'],
            ['Миостимуляция', '500 руб']
        ]
    },
    {

        'Основные услуги маникюра': [
            ['Классический маникюр', '500 руб'],
            ['Классический маникюр с покрытием', '600 руб'],
            ['Подпиливание ногтей', '200 руб'],
            ['Покрытие ногтей «Shellac»', '700 руб'],
            ['Покрытие ногтей «Shellac» френч', '900 руб'],
            ['Парафинотерапия - горячий парафин<br>(пилинг, коллагеновый крем для рук, парафин)', '300 руб']
        ],
        'Моделирование': [
            ['Наращивание ногтей', '1800 руб'],
            ['Гелевая технология<br>Под покраску', '1500 руб'],
            ['Гелевая технология<br>Французский маникюр', '1700 руб'],
            ['Гелевая технология<br>Гелевый маникюр', '1500 руб'],
            ['Гелевая технология<br>Снятие геля', '200 руб']
        ]
    },
    {
        'Оснонвые услуги педикюра': [
            ['Педикюр', '1000 руб'],
            ['Педикюр с покрытием', '1100 руб'],
            ['Парафинотерапия', '2500 руб'],
            ['Мужской педикюр', '1000 руб'],
            ['Французский падикюр', '300-400 руб']
        ]
    }
];
const namesBars = [
    "Парикмахерские услуги",
    "Косметология",
    "Маникюр",
    "Педикюр",
    "Другое"
];

window.addEventListener('DOMContentLoaded', () => {
    const maxWitdhTable = 580;




    const modalTrigger = document.querySelectorAll('[data-modal]'),
        modal = document.querySelector('.modal'),
        modalCloseBtn = document.querySelector('[data-close]');
    console.log(modalTrigger);
    console.log(modal);
    console.log(modalCloseBtn);

    function defineWidth() {

        let listTables = document.getElementsByClassName('prices');
        // listTables.forEach((x)=>{
        //     x.style.width = x.offsetWidth;
        // });
        for (let i = 0; i < listTables.length; ++i) {
            // not fixed listTables[i].style.width = listTables[i].offsetWidth + "px";
          //  listTables[i].style.width = maxWitdhTable + "px";
        }
    }

    let flag = false;
    modalTrigger.forEach((btn, index) => {
        btn.addEventListener('click', function () {

            modal.classList.add('show');
            modal.classList.remove('hide');

            // Либо вариант с toggle - но тогда назначить класс в верстке
            document.body.style.overflow = 'hidden';
            if (!flag) {
                defineWidth();
                flag = true;
            }
            initialazing(index);

        });
    });

    function closeModal() {
        modal.classList.add('hide');
        modal.classList.remove('show');
        // Либо вариант с toggle - но тогда назначить класс в верстке
        document.body.style.overflow = '';
    }

    modalCloseBtn.addEventListener('click', closeModal);

    modal.addEventListener('click', (e) => {
        if (e.target === modal) {
            closeModal();
        }
    });

    document.addEventListener('keydown', (e) => {
        if (e.code === "Escape" && modal.classList.contains('show')) {
            closeModal();
        }
    });

    //Работа с таблицей
    /*меню*/
    let tabs = document.querySelectorAll('.tabheader__item'),
        tabsContent = document.querySelectorAll('.tabcontent'),
        tabsParent = document.querySelector('.tabheader__items');
    //Создание таблицы
    tabsContent.forEach((element, i) => {
        let maxWitdh = 580;


        element.innerHTML = '<table class="prices"></table>';
        for (let key in arr[i]) {
            let row = document.createElement('tr');
            row.innerHTML = `<td colspan="2">${key}</td>`;
            element.querySelector('.prices').appendChild(row);
            for (let j = 0; j < arr[i][key].length; j++) {
                let row = document.createElement('tr');
                row.innerHTML = `
                 <td>${arr[i][key][j][0]}</td>
                 <td>${arr[i][key][j][1]}</td>
                 `;
                element.querySelector('.prices').appendChild(row);
            }
        }
        let table = element.childNodes[0]; //get table of price



    });

    //Создание ссылок на таблицу(меню подтаблиц)
    tabs.forEach((element, i) => {
        element.innerHTML = `${namesBars[i]}<div class="tabheader__item__mikroitems"></div>`;
        for (let key in arr[i]) {
            let row = document.createElement('div');
            row.className = "tabheader__item__mikroitem";
            row.innerText = `${key}`;
            element.querySelector('.tabheader__item__mikroitems').appendChild(row);
            //`<div class="tabheader__item__mikroitem">${key}</div>`;
        }
    });
    let microElements = document.querySelectorAll('.tabheader__item__mikroitem'); //Дохера
    let microTabs = document.querySelectorAll('.tabheader__item__mikroitems'); //Только 4(т.к разделов)

    function hideTabContent() {

        tabsContent.forEach(item => {
            item.classList.add('hide');
            item.classList.remove('show', 'fade');

            //item.style.display = 'node';
        });

        tabs.forEach(item => {
            item.classList.remove('tabheader__item_active');
        });
    }


    async function playAnimationShowRows(list) {
        let delayAndDoAnimation = (ms, elem) => {
            return new Promise(resolve => setTimeout(
                () => {
                    const val = 0;
                    elem.classList.remove('hide');
                    elem.classList.add('show', 'fade', 'lightSpeedIn');
                    resolve(val);
                }, ms
            ));
        };
        let removeAnimation = (elem) => {
            return new Promise(resolve => setTimeout(
                () => {
                    const val = 0;
                    elem.classList.remove('show', 'fade', 'lightSpeedIn');
                    resolve(val);

                }, 100
            ));
        };
        let variable;
        for (let i = 0; i < list.length; ++i) {
            variable = await delayAndDoAnimation(100, list[i]);
        }
        for (let i = 0; i < list.length; ++i) {
            variable = await removeAnimation(list[i]);
        }
        return variable;
    }




    function showTabContent(i = 0, j = 0) {
        tabsContent[i].classList.add('show', 'fade');
        tabsContent[i].classList.remove('hide');
        tabs[i].classList.add('tabheader__item_active');
    }

    function showListMicroBar(i = 0) {
        microTabs[i].classList.add('show', 'fade');
        let list = microTabs[i].childNodes;
        list.forEach(elem => {
            elem.classList.add('hide');
        });
        playAnimationShowRows(list);

        microTabs[i].classList.remove('hide');
        //Только лишь первый элемент в принципе фиксить
        microElements[0].classList.add('tabheader__item__mikroitem_active');
    }

    function hideListMicroBar() {
        microTabs.forEach(item => {
            item.classList.add('hide');
            item.classList.remove('show_call', 'fade', 'lightSpeedIn');

            //item.style.display = 'node';
        });

        microElements.forEach(item => {
            item.classList.remove('tabheader__item__mikroitem_active');
        });
    }

    function showPartTable(i = 0, j = 0) {
        //debugger;
        let conetentChildren = tabsContent[i].childNodes;
        //Считаем начальный индекс части таблицы
        //Счиатем количество эдлементов микротаблицы
        const tab = arr[i];
        let allCount = 0;
        let headerCount = 0;
        let countOfLines = 1;
        //По всем заголовкам(свойствам)
        for (let ptr in tab) {
            if (headerCount == j) {
                countOfLines += tab[ptr].length;
                break;
            }
            headerCount++;
            allCount++;
            // Добавляем количество ячеек каждого подзаголовка
            allCount += tab[ptr].length;
        }
        let lines = conetentChildren[0].childNodes;
        lines.forEach(item => {
            item.classList.remove('hide', 'show_call', 'fade', 'lightSpeedIn');
            //item.style.display = 'node';
        });

        for (let k = 0; k < lines.length; k++) {

            if (k == allCount) {
                k += countOfLines - 1;
            } else {
                lines[k].classList.add('hide');
            }
        }

        //Work with button
        setButtonPosition(tabsContent[i].childNodes[0]);
    }

    function setButtonPosition(table ){
        //debugger;
        //document.querySelectorAll('[data-modal]'
        let kek = table.offsetHeight;
        // ,
        // vek = table.getBoundingClientRect().width,
        // creck =table.clientWidth;
        // console.log("Размер: "+ table.className);
        // console.log("Размер: "+ kek);
        // console.log("Размер: "+ vek);
        // console.log("Размер: "+ creck);

        const btn = document.querySelector("[pointer]");
        console.log(btn.className);
        // btn.style.top = kek + 50 + "px";
        // btn.style.left = (table.offsetWidth)/2 +100 + "px";
    }

    function setActiveMicroitem(i = 0, j = 0) {
        let listElements = microTabs[i].childNodes;
        listElements.forEach((item, key) => {
            item.classList.remove('tabheader__item__mikroitem_active');
            if (key == j) {
                item.classList.add('tabheader__item__mikroitem_active');
            }
        });
    }

    const content = document.querySelector('.modal__content');
    tabsParent.addEventListener('click', function (event) {

        const target = event.target;
        console.log(target.classList);
        if (target && (target.classList.contains('tabheader__item'))) {
            content.scrollTop = 0;

            //Смотрим заголовки
            tabs.forEach((item, i) => {
                if (target == item) {
                    //Смотрим подзаголовки
                    if (target == microElements[i]) {
                        //console.log(" if target == work");
                    }
                    // microtabs[i].forEach((microitem, j)=>
                    // {

                    // });
                    hideTabContent();
                    showTabContent(i);
                    hideListMicroBar();
                    showListMicroBar(i);
                    //Выделим первую часть таблицы
                    setActiveMicroitem(i, 0);
                    showPartTable(i, 0);

                }

            });

        }
        if (target.classList.contains('tabheader__item__mikroitem')) {
            //debugger;
            //Смотрим подзаголовки
            //content.scrollTop = 0;
            $(".modal__content").animate({ scrollTop: 0 }, "slow");
            microTabs.forEach((microTab, i) => {
                if (microTab.contains(target)) {
                    let elemets = microTab.childNodes;
                    elemets.forEach(
                        (microelement, j) => {
                            if (microelement == target) {
                                //Нашли элемент ура
                                //i - номер таблицы, j - номерподтаблицы
                                setActiveMicroitem(i, j);
                                showPartTable(i, j);
                            }
                        }
                    );
                }
            });
        }
    });

    function initialazing(i = 0) {
        hideListMicroBar();
        hideTabContent();
        showTabContent(i);
        showListMicroBar(i);
        showPartTable(i);
    }
      //Работа с выдживжным меню для тф
      const mikroMenu = document.querySelector(".nav-toggle");
      const tabheader = document.querySelector(".tabheader");
      var isOpen = false;
      mikroMenu.addEventListener('click', function (event) {

          const target = event.target;
          console.log(target.classList);
          if (target) {
              closeMicroBar();
          }
      });
      function closeMicroBar(){
        if(!isOpen)
        {

            isOpen = true;

            tabheader.classList.add('fade');
            //tabheader.style.display = "block";

          }
          else{
              isOpen = false;
             // tabheader.style.display = "none";
              tabheader.classList.remove('fade');

        }
      }
    let alltabletr = document.querySelectorAll('tr');
    let textfield =document.querySelector('.peak-service-modal');

    alltabletr.forEach((elem) =>{

        elem.onclick = function() {

            //Получаем td


            if(elem.childElementCount>1)
            {

                let row = elem.cells[0];
                // let showedTable;
                // let
                // tabsContent.forEach(elem =>{
                //         if(elem.classList.contains('show')){
                //             showedTable = elem;
                //         }
                // })
                // showedTable.childNodes[0].childNodes.forEach(elem=>{
                //     if(!elem.classList.contains('hide')){

                //     }
                // });
                var now = new Date();
                console.log(now.getDay());
                console.log(now.getMonth());
                console.log(now.getFullYear());
                let categoryName = document.querySelector('.tabheader__item__mikroitem_active').innerText;
                console.log(`${categoryName}:${row.childNodes[0].data}`);
                textfield.setAttribute('value',`${categoryName}:${row.childNodes[0].data}`);

                closeModal();
            }

        };
    });

      // Этот медиа-запрос нацелен на области просмотра, которые имеют минимальную ширину 320 пикселей
    //   function check() {
    //     if (window.innerWidth < 1060) {

    //  }
});