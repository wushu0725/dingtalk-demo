import store from '../../store'
import router from '../../router'

const busstop = {
  state: {
    busStopId: '',
    busStopName: '',
    busStopAreaId: '',
    busStopAreaName: '',
    busStopAreaCanStop: '',
    busCode: '',
    busLicence: '',
    inOrOut: '',
    id: '',
    outState: '',
    inState: '',
    checkinUsername: ''
  },
  mutations: {
    setBusStopInfo: (state, busStopInfo) => {
      console.log(busStopInfo)
      state.busStopId = busStopInfo.busStopId
      state.busStopName = busStopInfo.busStopName
    },
    setBusStopAreaInfo: (state, busStopAreaInfo) => {
      console.log(busStopAreaInfo)
      state.busStopAreaId = busStopAreaInfo.busStopAreaId
      state.busStopAreaName = busStopAreaInfo.busStopAreaName
      state.busStopAreaCanStop = busStopAreaInfo.busStopAreaCanStop
    },
    setBusInfo: (state, busInfo) => {
      console.log(busInfo)
      state.busCode = busInfo.busCode
      state.busLicence = busInfo.busLicence
      state.inOrOut = busInfo.inOrOut
      state.id = busInfo.id
      state.outState = busInfo.outState
      state.inState = busInfo.inState
      state.checkinUsername = busInfo.checkinUsername
      state.busStopId = busInfo.busStopId
      state.busStopName = busInfo.busStopName
    }
  }
}
export default busstop
