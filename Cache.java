class Cache {
        Map<Integer, Integer> cache;
        int size;

        public Cache(int size){
            cache = new LinkedHashMap<>();
            this.size = size;
        }

        boolean isFull(){
            return size <= cache.size();
        }

        int add(int key){
            int value = 0;
            if (cache.containsKey(key)){
                value = cache.get(key);
                cache.remove(key);
                value+= 1;
                cache.put(key, value);
                return 1;
            } else {
                if (!isFull()){
                    cache.put(key, value);
                    return -1;
                } else {
                    remove();
                    cache.put(key, value);
                    return -1;
                }
            }
        }

        void remove(){
           if (cache != null && cache.size() > 0){
                int first = cache.entrySet().iterator().next().getKey();
                cache.remove(first);
            }
        }

        Set<Integer> getKeySet(){
            return cache.keySet();
        }
    }
