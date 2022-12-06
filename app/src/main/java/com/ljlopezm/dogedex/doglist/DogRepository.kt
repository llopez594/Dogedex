package com.ljlopezm.dogedex.doglist

import com.ljlopezm.dogedex.Dog
import com.ljlopezm.dogedex.api.ApiResponseStatus
import com.ljlopezm.dogedex.api.DogsApi.retrofitService
import com.ljlopezm.dogedex.api.dto.DogDTOMapper
import com.ljlopezm.dogedex.api.makeNetworkCall

class DogRepository {

    suspend fun donloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }

}