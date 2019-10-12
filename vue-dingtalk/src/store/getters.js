const getters = {
  nickname: state => state.user.nickname,
  userId: state => state.user.userId,
  avatar: state => state.user.avatar,
  role: state => state.user.role,
  busStopName: state => state.busstop.busStopName
}
export default getters
