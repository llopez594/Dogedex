package com.ljlopezm.dogedex.doglist

import com.ljlopezm.dogedex.Dog
import com.ljlopezm.dogedex.R
import com.ljlopezm.dogedex.api.ApiResponseStatus
import com.ljlopezm.dogedex.api.DogsApi.retrofitService
import com.ljlopezm.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {

    suspend fun donloadDogs(): ApiResponseStatus {
         return withContext(Dispatchers.IO) {
             try {
                 val dogListApiResponse = retrofitService.getAllDogs()
                 val dogDTOList = dogListApiResponse.data.dogs
                 val dogDTOMapper = DogDTOMapper()
                 ApiResponseStatus.Success(
                     dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
                 )
             } catch (e: UnknownHostException) {
                ApiResponseStatus.Error(R.string.unknown_host_exception_error)
             } catch (e: Exception) {
                 ApiResponseStatus.Error(R.string.unknown_error)
             }
        }
    }
}