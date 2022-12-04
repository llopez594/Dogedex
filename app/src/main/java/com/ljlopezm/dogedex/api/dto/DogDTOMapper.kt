package com.ljlopezm.dogedex.api.dto

import com.ljlopezm.dogedex.Dog

class DogDTOMapper {

    private fun fromDogDTOToDogDomain(dogDTO: DogDTO): Dog {
        with(dogDTO) {
            return Dog(id, index, name, type, heightFemale, heightMale, imageUrl, lifeExpectancy, temperament, weightFemale, weightMale)
        }
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog> {
        return dogDTOList.map { fromDogDTOToDogDomain(it) }
    }

}