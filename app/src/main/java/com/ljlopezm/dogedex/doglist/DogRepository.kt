package com.ljlopezm.dogedex.doglist

import com.ljlopezm.dogedex.Dog
import com.ljlopezm.dogedex.api.DogsApi.retrofitService
import com.ljlopezm.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun donloadDogs(): List<Dog> {
         return withContext(Dispatchers.IO) {
             val dogListApiResponse = retrofitService.getAllDogs()
             val dogDTOList = dogListApiResponse.data.dogs
             val dogDTOMapper = DogDTOMapper()
             dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}