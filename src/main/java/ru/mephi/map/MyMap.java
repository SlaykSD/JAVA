package ru.mephi.map;

/*
Реализовать словарь (map)
  Операции
  - Положить по ключу значение:          public void put(Object key, Object value);
  - Получить по ключу:                   public Object get(Object key);
  - Получить по ключу,                   public Object get(Object key, Object bydefault);
    если значение null, тогда надо
    вернуть значение по умолчанию,
    которое задается вторым параметром.
    Значение по умолчанию необходимо
    сохранить.
  - Удалить по ключу, возвращает текущее public Object remove(Object key);
    значение
  - Проверить наличие ключа:             public boolean keyContains(Object key);
  - Получить список ключей:              public List getKeys();
  - Получить список значений:            public List getValues();
  - Получить список пар: ключ, значение: public List getEntries();
  - Размер словаря:                      public int size();
  - Пустой или нет:                      public boolean isEmpty();
 */
public class MyMap implements map {
    public class Pair
    {
        private Object key;
        private Object value;
        public Pair()
        {
            key = null;
            value  = null;
        }
        public  Pair(Object key, Object value)
        {
            this.key = key;
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            boolean flag = false;
            if(obj instanceof Pair) {
                Pair pair= (Pair) obj;
                if(pair.key!=null && key !=null)
                    flag = this.key.equals(pair.key);
                    else
                        flag = (pair.key == null && key== null);
            }
            return flag;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private List dictList;

    @Override
    public String toString() {
        return "MyMap{|" +
                "dictList=" + dictList.toString() +
                "|}";
    }

    public MyMap()
    {
        dictList = new List();
    }
    public MyMap(Object key,Object value)
    {
        Pair newPair = new Pair(key,value);
        dictList = new List(newPair);
    }
    public void put(Object key, Object value)
    {
        //Ключи универсальные
        Pair old = new Pair(key,null);
        Pair newPair = new Pair(key,value);
        int ind = dictList.indexOf(old);
        if(ind < 0 )
            dictList.add(newPair);
       else
           dictList.set(ind,newPair);

    }
    public Object get(Object key)
    {
        Pair old = new Pair(key,null);
        int ind = dictList.indexOf(old);
        if(ind < 0 ){
            System.out.println("The key was not found");
            return null;
        };
        Pair res = (Pair)dictList.get(ind);
    //    if(res != null)
            return res.value;
       /* else
            throw new NullPointerException("Incorrect work in \"get\" in list");*/
    }
    public Object get(Object key, Object bydefault)
    {
        Pair old = new Pair(key,null);
        int ind = dictList.indexOf(old);
        if(ind < 0 )
            return bydefault;
        Pair res = (Pair)dictList.get(ind);
     //   if(res != null)
            return res.value;
 /*       else
            throw new NullPointerException("Incorrect work in \"get\" in list");*/
    }
    public Object remove(Object key)
    {
        Pair old = new Pair(key,null);
        int ind = dictList.indexOf(old);
        if(ind < 0 )
            return null;
        return ((Pair)dictList.remove(ind)).value;
    }
    public boolean keyContains(Object key)
    {
        Pair old = new Pair(key,null);
        int ind = dictList.indexOf(old);
        if(ind < 0 ){
            return false;
        }
        else
            return true;
    }
    public List getKeys()
    {
        List res  = new List();
        int size = dictList.size();
        for(int i =0 ; i< size; ++i)
            res.add(((Pair)dictList.get(i)).key);
        return res;
    }
    public List getValues()
    {
        List res  = new List();
        int size = dictList.size();
        for(int i =0 ; i< size; ++i)
            res.add(((Pair)dictList.get(i)).value);
        return res;
    }
    public List getEntries()
    {
        List res  = new List();
        int size = dictList.size();
        for(int i =0 ; i< size; ++i)
            res.add(((Pair)dictList.get(i)));
        return res;
    }
    public int size()
    {
        return dictList.size();
    }

    public boolean isEmpty() {
        return dictList.isEmpty();
    }

    public static void main(String... args) {
        MyMap newMap = new MyMap (null,null);
        newMap.put("312",3333);
        newMap.put("312",33323);
        newMap.put(213,"Кек");
        System.out.println(newMap.get(null));
        System.out.println(newMap.toString());

        System.out.println("\nПроверка неверного гет-запроса");
        System.out.println(newMap.get(12));
        System.out.println("\nПроверка неверного гет-запроса ч.2");
        System.out.println(newMap.get(null));
        System.out.println("\nПроверка на дубликат ключа: "+newMap.get("312"));
        System.out.println("\nПроверка дефолтного запроса: "+newMap.get("212",213));
        System.out.println("\nПроверка выдчаи размера мапы: "+newMap.size());
        System.out.println("\nПроверка наличия элементов: "+newMap.isEmpty());
        System.out.println("\nПроверка выдачи списка пар: "+newMap.getEntries());
        System.out.println("\nПроверка выдачи ключей: "+newMap.getKeys());
        System.out.println("\nПроверка выдачи элементов: "+newMap.getValues());

        newMap.put(null, 22.21312);
        newMap.remove("3247");
        newMap.remove(null);
        System.out.println("\nПроверка работы remove");
        System.out.println(newMap.toString());
        newMap.remove(null);
        newMap.remove("312");
        newMap.remove("6125");
        newMap.remove(213);
        newMap.remove(213.2133);
        newMap.remove(null);
        System.out.println("\nПроверка выдачи элементов: "+newMap.isEmpty());
        System.out.println("\nПроверка выдачи элементов: "+newMap.getEntries());
    }
}
